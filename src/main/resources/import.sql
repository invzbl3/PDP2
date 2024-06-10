INSERT INTO backlog (id, name, description)
VALUES ('uuid-1', 'Backlog 1', 'Description for backlog 1');
INSERT INTO backlog_item (id, status, story, story_points, summary, type, product_id, release_id, sprint_id, backlog_id)
VALUES ('uuid-2', 'Open', 'Story 1', 5, 'Summary for story 1', 'Feature', 'uuid-product', 'uuid-release', 'uuid-sprint',
        'uuid-1');
INSERT INTO task (id, name, description, hours_remaining, volunteer, backlog_item_id)
VALUES ('uuid-3', 'Task 1', 'Description for task 1', 10, 'Volunteer 1', 'uuid-2');
-- For testing purposes you can use the following queries for http://localhost:8081/h2-console/,
-- as for instance:

-- SELECT * FROM backlog;
-- SELECT id, name, description FROM backlog;
-- SELECT * FROM backlog_item;
-- SELECT id, status, summary FROM backlog_item;
-- SELECT * FROM task;
-- SELECT id, name, description FROM task;

-- Joining Tables

-- SELECT bi.id AS backlog_item_id, bi.status, bi.summary, b.id AS backlog_id, b.name AS backlog_name
-- FROM backlog_item bi
-- JOIN backlog b ON bi.backlog_id = b.id;

-- SELECT t.id AS task_id, t.name AS task_name, bi.id AS backlog_item_id, bi.status AS backlog_item_status
-- FROM task t
-- JOIN backlog_item bi ON t.backlog_item_id = bi.id;

-- SELECT b.id AS backlog_id, b.name AS backlog_name, b.description AS backlog_description,
--        bi.id AS backlog_item_id, bi.status AS backlog_item_status, bi.summary AS backlog_item_summary,
--        t.id AS task_id, t.name AS task_name, t.description AS task_description
-- FROM backlog b
-- JOIN backlog_item bi ON b.id = bi.backlog_id
-- JOIN task t ON bi.id = t.backlog_item_id;


-- Removing all data from existing tables:
-- Disable foreign key constraints
-- SET REFERENTIAL_INTEGRITY FALSE;

-- Delete data from each table
-- DELETE FROM backlog;
-- DELETE FROM backlog_item;
-- DELETE FROM task;

-- Re-enable foreign key constraints
-- SET REFERENTIAL_INTEGRITY TRUE;

-- Explanation:
-- SET REFERENTIAL_INTEGRITY FALSE: Temporarily disables foreign key constraints, allowing you to delete data without encountering constraint violations.
-- DELETE FROM <table_name>: Removes all rows from the specified table.
-- SET REFERENTIAL_INTEGRITY TRUE: Re-enables foreign key constraints after data deletion.

-- Notes:
-- Ensure that no other processes are accessing the database while performing these operations to avoid potential conflicts.
-- Always back up your data before performing bulk delete operations, especially in a production environment.
-- By following these steps and executing the provided queries, you can effectively remove data from all specified tables in your H2 database.