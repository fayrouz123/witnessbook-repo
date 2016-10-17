package tn.esprit.sigma.witnessbook.resources;

import tn.esprit.sigma.witnessbook.entities.Report;
import tn.esprit.sigma.witnessbook.service.ReportService;
import tn.esprit.sigma.witnessbook.resources.util.HeaderUtil;
import tn.esprit.sigma.witnessbook.security.Secured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * REST controller for managing Report.
 */
@Path("/api/report")
@Secured
public class ReportController {

    private final Logger log = LoggerFactory.getLogger(ReportController.class);

    @Inject
    private ReportService reportService;

    /**
     * POST : Create a new report.
     *
     * @param report the report to create
     * @return the Response with status 201 (Created) and with body the new
     * report, or with status 400 (Bad Request) if the report has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @POST
    public Response createReport(Report report) throws URISyntaxException {
        log.debug("REST request to save Report : {}", report);
        reportService.create(report);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/report/" + report.getId())),
                "report", report.getId().toString())
                .entity(report).build();
    }

    /**
     * PUT : Updates an existing report.
     *
     * @param report the report to update
     * @return the Response with status 200 (OK) and with body the updated
     * report, or with status 400 (Bad Request) if the report is not valid, or
     * with status 500 (Internal Server Error) if the report couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PUT
    public Response updateReport(Report report) throws URISyntaxException {
        log.debug("REST request to update Report : {}", report);
        reportService.edit(report);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "report", report.getId().toString())
                .entity(report).build();
    }

    /**
     * GET : get all the reports. <% if (pagination != 'no') {} @param pageable
     * the p
     *
     * agination information<% } if (fieldsContainNoOwnerOneToOne) {} @param
     * filter the filter of the r
     * equest<% }}
     * @return the Response with status 200 (OK) and the list of reports in
     * body<% if (pagination != 'no') {} @throws URISyntaxExce
     * ption if there is an error to generate the pagination HTTP headers<% }}
     */
    @GET
    public List<Report> getAllReports() {
        log.debug("REST request to get all Reports");
        List<Report> reports = reportService.findAll();
        return reports;
    }

    /**
     * GET /:id : get the "id" report.
     *
     * @param id the id of the report to retrieve
     * @return the Response with status 200 (OK) and with body the report, or
     * with status 404 (Not Found)
     */
    @Path("/{id}")
    @GET
    public Response getReport(@PathParam("id") Integer id) {
        log.debug("REST request to get Report : {}", id);
        Report report = reportService.find(id);
        return Optional.ofNullable(report)
                .map(result -> Response.status(Response.Status.OK).entity(report).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    /**
     * DELETE /:id : remove the "id" report.
     *
     * @param id the id of the report to delete
     * @return the Response with status 200 (OK)
     */
    @Path("/{id}")
    @DELETE
    public Response removeReport(@PathParam("id") Integer id) {
        log.debug("REST request to delete Report : {}", id);
        reportService.remove(reportService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "report", id.toString()).build();
    }

}
