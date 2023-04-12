package com.example.demo.Repository;



        import com.example.demo.model.WalletModel;
        import org.springframework.data.mongodb.repository.MongoRepository;

public interface WalletRepository extends MongoRepository<WalletModel, String> {
}
