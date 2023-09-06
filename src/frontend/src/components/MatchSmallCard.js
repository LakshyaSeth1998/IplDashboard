import { React } from 'react';
import { Link } from 'react-router-dom';

import './MatchSmallCard.scss';
import { IPLTeamName } from '../constants/IPLTeamName';

export const MatchSmallCard =  ({match, teamName}) => {
    const otherTeam = teamName===match.homeTeam ? match.awayTeam : match.homeTeam;
    const otherTeamRoute = `/teams/${otherTeam}`;
    const isMatchWon = match.winner === teamName;
  return (
    <div className={isMatchWon ? 'MatchSmallCard won-card' : 'MatchSmallCard lost-card'}>
      <span className='vs'>vs</span>
      <h1><Link to={otherTeamRoute}>{IPLTeamName[otherTeam]}</Link></h1>
      <p>{match.result} </p>
    </div>
  );
}