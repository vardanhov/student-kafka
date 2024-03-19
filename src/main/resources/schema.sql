DROP TABLE IF EXISTS public.json_store ;

CREATE TABLE  public.json_store
(
    id      serial4      NOT NULL,
    json   jsonb NULL,
    CONSTRAINT json_store_pkey PRIMARY KEY (id)
);




