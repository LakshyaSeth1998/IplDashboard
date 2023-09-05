import { React } from 'react';
import { Link } from 'react-router-dom';

export const MatchSmallCard =  ({match, teamName}) => {
    const otherTeam = teamName===match.homeTeam ? match.awayTeam : match.homeTeam;
    const otherTeamRoute = `/teams/${otherTeam}`;
  return (
    <div className="MatchSmallCard">
      <p>VS <Link to={otherTeamRoute}>{otherTeam}</Link>
      </p>
      <p>{match.result} </p>
    </div>
  );
}