-- FUNCTION: public.countandgroupallbyarticles()

-- DROP FUNCTION public.countandgroupallbyarticles();

CREATE OR REPLACE FUNCTION public.countandgroupallbyarticles(
)
    RETURNS TABLE(amount bigint, articles character varying)
    LANGUAGE 'plpgsql'

    COST 100
    VOLATILE
    ROWS 1000
AS $BODY$
BEGIN
    RETURN query
        SELECT COUNT(order_details.article_id) AS amount, article.article_name as articles FROM order_details
        INNER JOIN article ON order_details.article_id=article.id  GROUP BY articles
        ORDER BY amount ASC;
END$BODY$;

ALTER FUNCTION public.countandgroupallbyarticles()
    OWNER TO postgres;
