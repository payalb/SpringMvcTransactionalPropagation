Required: If a transaction exist, use the same tx, else create a new one

Requires_new: Every time create a new tx.

Mandatory: The tx shud exist. If it exist, will execute in same tx. If it does not exist, will throw an error

Never: Tx shud not exist. If does not exist, it will create a new tx. If it exists, will throw an exception

Not_supported: if a parent tx exist, it will suspend it.   Will always execute without a tx.

supported: If tx exist, use it. If does not exist, execute without it

TransactionDefinition.PROPAGATION_MANDATORY

Supports a current transaction; throws an exception if no current transaction exists.

2	
TransactionDefinition.PROPAGATION_NESTED

Executes within a nested transaction if a current transaction exists.

3	
TransactionDefinition.PROPAGATION_NEVER

Does not support a current transaction; throws an exception if a current transaction exists.

4	
TransactionDefinition.PROPAGATION_NOT_SUPPORTED

Does not support a current transaction; rather always execute nontransactionally.

5	
TransactionDefinition.PROPAGATION_REQUIRED

Supports a current transaction; creates a new one if none exists.

6	
TransactionDefinition.PROPAGATION_REQUIRES_NEW

Creates a new transaction, suspending the current transaction if one exists.

7	
TransactionDefinition.PROPAGATION_SUPPORTS

Supports a current transaction; executes non-transactionally if none exists.

8	
TransactionDefinition.TIMEOUT_DEFAULT

Uses the default timeout of the underlying transaction system, or none if timeouts are not supported.




