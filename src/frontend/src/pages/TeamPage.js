import { React, useEffect, useState } from 'react';
import { MatchDetailCard } from '../components/MatchDetailCard';
import { MatchSmallCard } from '../components/MatchSmallCard';
import { Link, useParams } from 'react-router-dom';
import { PieChart } from 'react-minimal-pie-chart';

import { IPLTeamName } from '../constants/IPLTeamName';
import './TeamPage.scss';

export const TeamPage =  () => {
    const [team, setTeam] = useState(null);
    const { teamName } = useParams(); 

    useEffect(
        ()=>{
            const fetchMatches = async () => {
                const response=await fetch(`http://localhost:8080/team/${teamName}`);
                const data= await response.json();
                console.log(data);
                setTeam(data);
            }
            fetchMatches();
        },[teamName]
    );
    if(!team || !team.teamName){
        return <h1>Team Not Found!</h1>
    }
  return (
    <div className="TeamPage">
      {team ? (
                <>
                    <div className='team-name-section'><h1>{IPLTeamName[team.teamName]}</h1></div>
                    <div className='win-loss-section'>
                        Win/Loss
                        <PieChart
                            data={[
                                { title: 'Wins', value: team.totalWins, color: '#4da375' },
                                { title: 'Losses', value: team.totalMatches - team.totalWins, color: '#a34d5d' }
                            ]}
                            />
                    </div>
                    <div className='match-detail-section'>
                        <h3>Latest Matches</h3>
                        <MatchDetailCard match={team.latestMatches[0]} teamName={team.teamName} />
                    </div>
                    {team.latestMatches.slice(1).map(match => <MatchSmallCard key={match.id} match={match} teamName={team.teamName} />)}
                    <div className='more-link'>
                        <Link to={`/teams/${teamName}/matches/${process.env.REACT_APP_DATA_END_YEAR}`}>More ></Link>
                    </div>
                </>
            ) : (
                <p>Loading...</p>
            )}
    </div>
  );
}