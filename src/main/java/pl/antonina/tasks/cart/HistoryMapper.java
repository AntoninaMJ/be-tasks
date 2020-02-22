package pl.antonina.tasks.cart;

import org.springframework.stereotype.Component;
import pl.antonina.tasks.child.ChildMapper;

@Component
public class HistoryMapper {

    private final ChildMapper childMapper;

    public HistoryMapper(ChildMapper childMapper) {
        this.childMapper = childMapper;
    }

    public HistoryView mapHistoryView(History history) {
        HistoryView historyView = new HistoryView();
        historyView.setChildView(childMapper.mapChildView(history.getChild()));
        historyView.setMessage(history.getMessage());
        historyView.setQuantity(history.getQuantity());
        historyView.setModificationDate(history.getModificationDate());
        return historyView;
    }
}
