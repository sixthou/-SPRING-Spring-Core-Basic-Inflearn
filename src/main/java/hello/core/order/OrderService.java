package hello.core.order;

public interface OrderService {
    Order ceateOrder(Long memberId, String itemName, int itemPrice);
}
