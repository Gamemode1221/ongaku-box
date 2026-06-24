DROP TABLE Music;

CREATE TABLE Music
(
    ID              NUMBER(10, 0)       NOT NULL,
    TITLE           VARCHAR2(300 CHAR)  NOT NULL, -- 💡 VARCHAR2 변경 및 글자수(CHAR) 기준 지정
    LYRICS          CLOB,                         -- 💡 가사는 무제한 저장 가능한 CLOB으로 변경!
    DESCRIPTION     VARCHAR2(4000 CHAR) NOT NULL, -- 💡 감상평 작성을 위해 4000글자로 확장
    ARTIST          VARCHAR2(200 CHAR)  NOT NULL,
    ALBUM           VARCHAR2(300 CHAR),           -- 💡 앨범명 유연성을 위해 300글자로 확장 및 NULL 허용
    GENRE           VARCHAR2(100 CHAR)  NOT NULL,
    YOUTUBE_URL     VARCHAR2(1000 CHAR),
    VIEW_COUNT      NUMBER(19, 0) DEFAULT 0,
    LIKE_COUNT      NUMBER(19, 0) DEFAULT 0,
    COVER_IMAGE_URL VARCHAR2(1000 CHAR),
    RELEASED_AT     DATE                NOT NULL,
    CREATED_AT      DATE                NOT NULL,
    PRIMARY KEY (ID)
);

DROP SEQUENCE MUSICID_SEQ;

CREATE SEQUENCE MUSICID_SEQ
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 9999999
    CACHE 2;

DELETE
FROM Music;

COMMIT;