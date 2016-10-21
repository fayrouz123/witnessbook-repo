package tn.esprit.sigma.witnessbook.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import tn.esprit.sigma.witnessbook.entities.Report;
import tn.esprit.sigma.witnessbook.resources.util.HeaderUtil;
import tn.esprit.sigma.witnessbook.service.ReportService;


@Path("/report")
public class ReportController {


    @EJB
    private ReportService reportService;

    @POST
    public Response createReport(Report report) throws URISyntaxException {
        reportService.create(report);
        return HeaderUtil.createEntityCreationAlert(Response.created(new URI("/resources/api/report/" + report.getId())),
                "report", report.getId().toString())
                .entity(report).build();
    }

    @PUT
    public Response updateReport(Report report) throws URISyntaxException {
        reportService.edit(report);
        return HeaderUtil.createEntityUpdateAlert(Response.ok(), "report", report.getId().toString())
                .entity(report).build();
    }

    
    @GET
    public List<Report> getAllReports() {
        List<Report> reports = reportService.findAll();
        return reports;
    }

   
    @Path("/{id}")
    @GET
    public Response getReport(@PathParam("id") Integer id) {
        Report report = reportService.find(id);
        return Optional.ofNullable(report)
                .map(result -> Response.status(Response.Status.OK).entity(report).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    
    @Path("/{id}")
    @DELETE
    public Response removeReport(@PathParam("id") Integer id) {
        reportService.remove(reportService.find(id));
        return HeaderUtil.createEntityDeletionAlert(Response.ok(), "report", id.toString()).build();
    }

}
