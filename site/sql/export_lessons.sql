SELECT l.id, l.hebrewName name, l.description, l.originalName, l.url, s.name AS subtopic, t.name AS topic 
FROM lesson l, subtopic s, topic t WHERE l.subtopic_id = s.id AND s.topic_id = t.id;