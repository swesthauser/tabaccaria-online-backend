package tbz.modul151.tabaccariaonlinebackend.domainModels.stock;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService{

    private StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    private Stock findAllThrow (Optional<Stock> optional) throws NoSuchElementException {
        if(optional.isPresent()){
            return optional.get();
        } else throw new NoSuchElementException("No value present");
    }

    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(String id) {
        return findAllThrow(stockRepository.findById(id));
    }

    @Override
    public Stock createNewStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock updateStock(Stock stock, String id) {
        findAllThrow(stockRepository.findById(id));
        stock.setId(id);
        return stockRepository.save(stock);
    }

    @Override
    public Stock deleteStock(String id) {
        stockRepository.deleteById(id);
        return null;
    }
}
