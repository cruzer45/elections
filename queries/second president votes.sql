SELECT CONCAT_WS(' ',first_name,last_name) as 'Candidate', COUNT(vote.id) as 'Votes'
FROM vote
INNER JOIN candidate ON candidate.id = vote.second_vice_president_id
GROUP BY second_vice_president_id
ORDER BY COUNT(vote.id) DESC