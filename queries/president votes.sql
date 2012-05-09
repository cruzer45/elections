SELECT CONCAT_WS(' ',first_name,last_name) AS 'Candidate', COUNT(vote.id) AS 'Votes'
FROM vote
INNER JOIN candidate ON candidate.id = vote.treasurer_id
GROUP BY treasurer_id
ORDER BY COUNT(vote.id) DESC