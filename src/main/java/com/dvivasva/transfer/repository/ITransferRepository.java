package com.dvivasva.transfer.repository;

import com.dvivasva.transfer.Model.Transfer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransferRepository extends ReactiveMongoRepository<Transfer, String> {


}
