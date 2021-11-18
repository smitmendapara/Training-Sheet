package mobileBill;

import java.util.concurrent.ConcurrentHashMap;

public class BasePriceWorker implements Runnable
{
    private ConcurrentHashMap<String,Integer> basePrices = new ConcurrentHashMap<String, Integer>();

    public BasePriceWorker()
    {
        basePrices.put("samsung", 1000);

        basePrices.put("iphone", 3000);

        basePrices.put("redmi", 2000);
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                String product = CommonUtil.takeProduct();

                if (product != null)
                {
                    int baseprice = basePrices.get(product);

                    CommonUtil.putServiceTaxPrice(baseprice);
                }
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
