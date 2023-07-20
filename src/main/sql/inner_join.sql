SELECT * FROM resume r
JOIN contact c
ON r.uuid = c.resume_uuid
WHERE r.uuid = 'uuid1'
   OR r.uuid = 'uuid2'