import { React } from 'react';
import { Link } from 'react-router-dom';

import './MatchDetailCard.scss';
import { IPLTeamName } from '../constants/IPLTeamName';

export const MatchDetailCard =  ({match, teamName}) => {
    
    const otherTeam = teamName===match.homeTeam ? match.awayTeam : match.homeTeam;
    const otherTeamRoute = `/teams/${otherTeam}`;
    const isMatchWon = match.winner === teamName;
    
  return (
    <div className={isMatchWon ? 'MatchDetailCard won-card' : 'MatchDetailCard lost-card'}>
      <div>
        <span className='vs'>vs</span>
        <h1><Link to={otherTeamRoute}>{IPLTeamName[otherTeam]}</Link></h1>
        <h2 className='start-date'>{match.startDate}</h2>
        <h3 className='venue-name'>at {match.venueName}</h3>
        <h3 className='result'>{match.result} </h3>
      </div>
      <div className='additional-detail'>
        <h3>Home Team </h3>
        <p>{match.homeTeam}</p>
        <h3>Away Team</h3>
        <p>{match.awayTeam}</p>
        <h3>Man Of The Match</h3>
        <p>{match.pom}</p>
        <h3>Umpires</h3>
        <p>{match.umpire1}, {match.umpire2}</p>
      </div>
      
    </div>
  );
}