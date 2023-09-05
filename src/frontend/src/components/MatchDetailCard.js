import { React } from 'react';
import { Link } from 'react-router-dom';

export const MatchDetailCard =  ({match, teamName}) => {
    const otherTeam = teamName===match.homeTeam ? match.awayTeam : match.homeTeam;
    const otherTeamRoute = `/teams/${otherTeam}`;
  return (
    <div className="MatchDetailCard">
      <h3>Latest Matches</h3>
      <h2>VS <Link to={otherTeamRoute}>{otherTeam}</Link></h2>
      <h2>{match.startDate}</h2>
      <h3>at {match.venueName}</h3>
      <h3>{match.result} </h3>
    </div>
  );
}