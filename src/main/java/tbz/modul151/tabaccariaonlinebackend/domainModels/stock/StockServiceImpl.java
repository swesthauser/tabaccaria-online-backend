package tbz.modul151.tabaccariaonlinebackend.domainModels.stock;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService{

    private StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<Stock> getAllStock() {
        return null;
    }

    @Override
    public Stock getStockById(String id) {
        return null;
    }

    @Override
    public Stock createNewStock(Stock stock) {
        return null;
    }

    @Override
    public Stock updateStock(Stock stock, String id) {
        return null;
    }

    @Override
    public Stock deleteStock(String id) {
        return null;
    }
}
