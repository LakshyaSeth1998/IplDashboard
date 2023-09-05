import { React, useEffect, useState } from 'react';
import { MatchDetailCard } from '../components/MatchDetailCard';
import { MatchSmallCard } from '../components/MatchSmallCard';
import { useParams } from 'react-router-dom';

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
                    <h1>{team.teamName}</h1>
                    <MatchDetailCard match={team.latestMatches[0]} teamName={team.teamName} />
                    {team.latestMatches.slice(1).map(match => <MatchSmallCard match={match} teamName={team.teamName} />)}
                    
                </>
            ) : (
                <p>Loading...</p>
            )}
    </div>
  );
}