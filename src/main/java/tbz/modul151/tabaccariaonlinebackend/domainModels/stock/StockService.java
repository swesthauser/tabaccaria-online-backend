package tbz.modul151.tabaccariaonlinebackend.domainModels.stock;

import tbz.modul151.tabaccariaonlinebackend.domainModels.stock.Stock;

import java.util.List;

public interface StockService {

    public List<Stock> getAllStock();
    public Stock getStockById(String id);
    public Stock createNewStock(Stock stock);
    public Stock updateStock (Stock stock, String id);
    public Stock deleteStock(String id);
}
