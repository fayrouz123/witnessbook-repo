package tn.esprit.sigma.witnessbook.service;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.sigma.witnessbook.entities.Post;
import tn.esprit.sigma.witnessbook.interfaces.IPostServiceLocal;
import tn.esprit.sigma.witnessbook.interfaces.IPostServiceRemote;
import tn.esprit.sigma.witnessbook.service.AbstractService;

@Stateless
@Named("post")
public class PostService extends AbstractService<Post> implements IPostServiceLocal,IPostServiceRemote{
	@PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostService() {
        super(Post.class);
    }

}
