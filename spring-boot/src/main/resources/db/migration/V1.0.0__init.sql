CREATE TABLE GITHUB_PROJECT (
  id IDENTITY  NOT NULL PRIMARY KEY,
  org_name VARCHAR(50) NOT NULL,
  repository_name VARCHAR(50) NOT NULL UNIQUE,
);

CREATE INDEX index_repository_name ON GITHUB_PROJECT(repository_name);