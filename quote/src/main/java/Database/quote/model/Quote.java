package Database.quote.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Quote {
	@Column(name="ACCOUNT_ID")
	private String accountId;
	@Column(name="OWNER_ID")
	private String ownerId;
	@Column(name="CUSTOMER_ID")
	private Long customerId;
	@Column(name="CONTACT_ID")
	private Long contactId;
	@Column(name="DEAL_ID")
	private Long dealId;
	@Column(name="QUOTE_CODE")
	private String quoteCode;
	@Column(name="QUOTE_DATE")
	private Date quoteDate;
	@Column(name="REG_USER")
	private String regUser;
	@Column(name="UPD_USER")
	private String updUser;
	@Column(name="REG_DTTM")
	private Date regDttm;
	@Column(name="UPD_DTTM")
	private Date updDttm;
	@Column(name="PRODUCT_AMOUNT")
	private Double productAmount;
	@Column(name="WARRANTY")
	private String warranty;
	@Column(name="EXCHANGE_RATE")
	private Double exchangeRate;
	@Column(name="PRODUCT_STATUS")
	private String productStatus;
	@Column(name="TIME_DELIVERY")
	private String timeDelivery;
	@Column(name="ADDRESS_DELIVERY")
	private String addressDelivery;
	@Column(name="PAYMENT_PERIOD")
	private String paymentPeriod;
	@Column(name="PAYMENT_METHOD")
	private String paymentMethod;
	@Column(name="PAYMENT_FORM")
	private String paymentForm;
	@Column(name="STAGE")
	private String stage;
	@Column(name="NOTE")
	private String note;
	@Column(name="TAX_AMOUNT")
	private Double taxAmount;
	@Column(name="DISCOUNT_AMOUNT")
	private Double discountAmount;
	@Column(name="SHIPPING_CHARGE")
	private Double shippingCharge;
	@Column(name="ADDRESS_BILL")
	private String addressBill;
	@Column(name="TRANSPORT")
	private String transport;
	@Column(name="TERM_CONDITION")
	private String termCondition;
	@Column(name="VALID_UNTIL")
	private Date validUntil;
}
