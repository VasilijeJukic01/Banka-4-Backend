package rs.banka4.bank_service.tx.otc.config;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.*;
import rs.banka4.bank_service.domain.trading.db.ForeignBankId;
import rs.banka4.bank_service.tx.data.*;

public interface InterbankService {
    @GET("public-stock")
    Call<List<PublicStock>> getPublicStocks();

    @POST("negotiations")
    Call<ForeignBankId> sendCreateOtc(@Body OtcOffer offer);

    @PUT("negotiations/{routingNumber}/{id}")
    Call<Void> sendUpdateOtc(
        @Body OtcOffer offer,
        @Path("routingNumber") long routingNumber,
        @Path("id") String id
    );

    @GET("negotiations/{routingNumber}/{id}")
    Call<OtcNegotiation> sendGetOtcNegotiation(
        @Path("routingNumber") long routingNumber,
        @Path("id") String id
    );

    @POST("interbank")
    Call<TransactionVote> sendNewTx(@Body Message.NewTx newTx);

    @POST("interbank")
    Call<Void> sendCommit(@Body Message.CommitTx commitTx);

    @POST("interbank")
    Call<Void> sendRollback(@Body Message.RollbackTx rollbackTx);

    @DELETE("negotiations/{routingNumber}/{id}")
    Call<Void> closeNegotiation(@Path("routingNumber") long routingNumber, @Path("id") String id);

    @GET("negotiations/{routingNumber}/{id}/accept")
    Call<Void> acceptNegotiation(@Path("routingNumber") long routingNumber, @Path("id") String id);

    @GET("user/{routingNumber}/{id}")
    Call<UserInformation> getUserInfo(
        @Path("routingNumber") long routingNumber,
        @Path("id") String id
    );
}
