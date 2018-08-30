CREATE TABLE CROL_QUEUE (
  ID BIGSERIAL NOT NULL,
  USER_ID INTEGER NOT NULL,
  ADDED_DT    TIMESTAMPTZ NOT NULL,
  SCHEDULED_DT     TIMESTAMPTZ NOT NULL,
  PROCESSED_DT     TIMESTAMPTZ,
  FIRST_NAME    VARCHAR(250),
  LAST_NAME    VARCHAR(250),
  PHOTO_50    VARCHAR(500),
  PHOTO_100    VARCHAR(500),
  PHOTO_200    VARCHAR(500),
  SEX    SMALLINT,
  BDATE VARCHAR(100),
  VERIFYIED SMALLINT,
  CONSTRAINT CROL_QUEUE_PK PRIMARY KEY (ID)
);

CREATE INDEX CROL_QUEUE_QIDX
  ON CROL_QUEUE (SCHEDULED_DT);

CREATE UNIQUE INDEX CROL_QUEUE_USER_IDX
  ON CROL_QUEUE (USER_ID);