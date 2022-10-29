package factory;

import dao.impls.ProductsRepository;
import dao.interfaces.IRepository;
import enums.RepositoryType;

public class RepositoryFactory {
    private RepositoryFactory(){};

    public static IRepository createRepository(RepositoryType type){
        switch (type){
            case PRODUCT: return new ProductsRepository();
            default: throw new IllegalArgumentException("Error");
        }
    }

}
