<h1>CLCrypt</h1>

------------------

#### What is CLCrypt?
CLCrypt is a simple command line text encrypting tool written in Java

#### Running
Running CLCrypt is simple. All you need to do is pass one command line argument.

* `-t, --type <type>` The type of hash to use. Can be any of the following: MD5, SHA1, SHA256 or SHA512 (more might come soon).
If the type is invalid, it will default to MD5.
* `<text> [...]` After specifying the type of hash to use, specify the text. Separate a string with `"` to treat is as one (useful if it has spaces.) To pass more than one string, just separate them by spaces. To use `"` in a string, it will have to be escaped using `\`. This will now make it `\"`.

#### Building
To build CLCrypt you need Maven
* Run `mvn clean package` from the command line

Voila, the final jar will be in the `target` folder.