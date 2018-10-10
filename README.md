<h1>CLCrypt</h1>

#### What is CLCrypt?
CLCrypt is a simple command line text encrypting tool written in Java

#### Running
Running CLCrypt is simple. All you need to do is pass one command line argument.

* `-t, --type <type>` The type of hash to use. Can be any of the following: MD5, SHA1, SHA256, SHA384 or SHA512 (more might come soon).
* `<text> [...]` After specifying the type of hash to use, specify the text. Separate a string with `"` to treat is as one (useful if it has spaces.) To pass more than one string, just separate them by spaces. To use `"` in a string, it will have to be escaped using `\`. This will now make it `\"`.

#### Building
To build CLCrypt you need Gradle, or if not, you can use the provided scripts:

To use the scripts, run either:
* Linux/*NIX/macOS: `./gradlew shadowJar`
* Windows: `gradlew.bat shadowJar`

Or just use the gradle command:
* `gradle shadowJar`

from the command line

The final jar will be in the `build/libs` folder.