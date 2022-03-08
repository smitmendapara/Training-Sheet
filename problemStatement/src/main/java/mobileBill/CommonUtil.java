package mobileBill;

import java.util.concurrent.LinkedBlockingQueue;

public class CommonUtil
{
    private final static LinkedBlockingQueue<String> m_basePriceQueue = new LinkedBlockingQueue<String>();

    private final static LinkedBlockingQueue<Integer> m_taxPriceQueue = new LinkedBlockingQueue<Integer>();

    private final static LinkedBlockingQueue<Integer> m_GSTPriceQueue = new LinkedBlockingQueue<Integer>();

    private final static LinkedBlockingQueue<Integer> m_TotalPriceQueue = new LinkedBlockingQueue<Integer>();

    public static String takeProduct()
    {
        try
        {
            return m_basePriceQueue.take();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return null;
    }

    public static void putProduct(String productName)
    {
        try
        {
             m_basePriceQueue.add(productName);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static int takeServiceTaxPrice()
    {
        try
        {
            return m_taxPriceQueue.take();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return 0;
    }

    public static void putServiceTaxPrice(int price)
    {
        try
        {
            m_taxPriceQueue.add(price);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static void putGSTPrice(int price)
    {
        try
        {
            m_GSTPriceQueue.add(price);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static int takeGSTPrice()
    {
        try
        {
            return m_GSTPriceQueue.take();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return 0;
    }

    public static void putTotalPrice(int totalPrice)
    {
        try
        {
            m_TotalPriceQueue.add(totalPrice);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static int takeTotalPrice()
    {
        try
        {
            return m_TotalPriceQueue.take();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }

        return 0;
    }
}

