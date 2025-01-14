package et.com.gebeya.paymentservice.repository;

import et.com.gebeya.paymentservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer>, JpaSpecificationExecutor<Payment> {
}
