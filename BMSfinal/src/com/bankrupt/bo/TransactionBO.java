package com.bankrupt.bo;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bankrupt.dao.TransactionDAO;
import com.bankrupt.exception.TransactionBusinessException;
import com.bankrupt.exception.TransactionException;
import com.bankrupt.vo.AccountVO;
import com.bankrupt.vo.TransactionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TransactionBO.
 */
public class TransactionBO {
	private static final Logger LOG = Logger.getLogger("TransactionBO");
	/** The avo. */
	AccountVO avo = new AccountVO();
//	TransactionVO txvo = new TransactionVO();
	/** The td. */
TransactionDAO td = new TransactionDAO();
	
	
	/**
	 * Validate account number.
	 *
	 * @param temp the acc num
	 * @return the account vo
	 * @throws TransactionException the transaction exception
	 * @throws TransactionBusinessException the transaction business exception
	 */
	public AccountVO validateAccountNumber(String temp) throws TransactionException, TransactionBusinessException 
	{
		LOG.info("Entered into validateAccountNumber method of TransactionBO class");
		
		avo = td.fetchDetails(temp);
		LOG.info("Return Statement of validateAccountNumber method of TransactionBO class");
		
		return avo;
		
	}
	
	/**
	 * Do deposit.
	 *
	 * @param txnvo the txnvo
	 * @throws TransactionException the transaction exception
	 */
	public void doDeposit(TransactionVO txnvo) throws TransactionException  
	{
		LOG.info("Entered into doDeposit method of TransactionBO class");
		
		double bal=0;
		
		bal = td.getBalance(txnvo.getAccNumber());
		
		bal = bal + txnvo.getAmount();
		
		txnvo.setBalance(bal);
		boolean a = td.transactionDetails(txnvo);
		LOG.info("Return Statement of doDeposit method of TransactionBO class");
		
		
	}
	
	/**
	 * Do withdrawal.
	 *
	 * @param txnvo the txnvo
	 * @throws TransactionBusinessException the transaction business exception
	 * @throws TransactionException the transaction exception
	 */
	public void doWithdrawal(TransactionVO txnvo) throws  TransactionBusinessException, TransactionException
	{
		
		LOG.info("Entered into doWithdrawal method of TransactionBO class");
		double bal=0;
		double minbal=0;
		
		bal = td.getBalance(txnvo.getAccNumber());
		
		if(txnvo.getAccType().equalsIgnoreCase("savings"))
		{
			
			minbal = td.getMinimumBalance(txnvo.getAccNumber());
		}
		if(bal<txnvo.getAmount())
		{
			
			throw new TransactionBusinessException("Insufficient balance ");
		}
		else if((bal-txnvo.getAmount())<minbal)
		{
			
			throw new TransactionBusinessException("Plzzz maintain minimum balance in your account ");
		}
		else
		{
			bal = bal - txnvo.getAmount();
			txnvo.setBalance(bal);
			boolean b = td.transactionDetails(txnvo);
			
		}
		LOG.info("Return Statement of doWithdrawal method of TransactionBO class");
		
	}
	
	/**
	 * Do loan emi debit.
	 *
	 * @param txnvo the txnvo
	 * @throws TransactionException the transaction exception
	 * @throws TransactionBusinessException 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void doLoanEmiDebit(TransactionVO txnvo) throws TransactionException, TransactionBusinessException 
	{
		LOG.info("Entered into doLoanEmiDebit method of TransactionBO class");
		
		double emi=0;
		
		emi = td.getEmiAmount(txnvo.getAccNumber());
		txnvo.setAmount(emi);
		double bal=0;
		double minbal=0;
		
		bal = td.getBalance(txnvo.getAccNumber());
		if(txnvo.getAccType().equalsIgnoreCase("savings"))
		{
			minbal = td.getMinimumBalance(txnvo.getAccNumber());
		}
		if(bal<txnvo.getAmount())
		{
			throw new TransactionBusinessException("Insufficient balance ");
		}
		else if((bal-emi)<minbal)
		{
			throw new TransactionBusinessException("Plzzz maintain minimum balance in your account ");
		}
		else
		{
			bal = bal - emi;
			txnvo.setBalance(bal);
			boolean b = td.transactionDetails(txnvo);
			
		}
		LOG.info("Return Statement of doLoanEmiDebit method of TransactionBO class");
		
	}
	

}
