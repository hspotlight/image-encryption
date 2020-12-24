# Description
This image encryption uses XOR operation to encrypt and decrypt image files.

XOR operation can be used as symmetric key due to the its property. If we XOR the same number twice, it will cancel each other.

# XOR truth table
| A | B | A XOR B |
|---|---|---------|
| 0 | 0 | 0       |
| 0 | 1 | 1       |
| 1 | 0 | 1       |
| 1 | 1 | 0       |

## For example
given 10, then we XOR with 5 twice. the result will be the original number.
``` 
10 ^ 5 = 15
15 ^ 5 = 10
```

# Step to follow
1. Compile java code 
$ javac Encryption.java

2. Execute Encryption (Encrypt) - a user must pass two argument filename and encryption key (number)
$ java Encryption image.png 5
    
    NOTE: after execution it will generate image-encrypted.png file, which is corrupted and cannot be open.

3. Execute Encryption (Decrypt)
java Encryption image-encrypted.png 5
after execution it will generate image-encrypted-encrypted.png file, which is now can be open.