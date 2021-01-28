# Dokument Validate

[![Download](https://api.bintray.com/packages/r2a-engineering/dokument-validator/br.eng.r2a.dokument/images/download.svg) ](https://bintray.com/r2a-engineering/dokument-validator/br.eng.r2a.dokument/_latestVersion)
[![codecov](https://codecov.io/gh/r2a-engineering/dokument-validate/branch/main/graph/badge.svg?token=AHCOYCVPR7)](https://codecov.io/gh/r2a-engineering/dokument-validate)

## Requirements

JDK 1.8 or greater


## How to use

- Gradle

Add jCenter repository on your build.gradle, and add implementation of dokument.

```groovy
repositories {
   jcenter()
}


dependencies {
  implementation 'br.eng.r2a.dokument:core:{dokument_version}'
}
```

### How to use 

To use this library, you must instanciate the class ```DokumentValidator```, passing the document value and one of Documents objects.

```kotlin
  val dokument = DokumentValidator("123123123", CPF)
  print(dokument.validate())
```
or:

```kotlin
  val dokument = DokumentValidator(CPF)
  print(dokument.validate("123123123"))
```

#### List of current supported documents by countries

- Brazil
  - CPF - ```br.eng.r2a.dokument.documents.brazil.CPF```
  - CNPJ - ```br.eng.r2a.dokument.documents.brazil.CNPJ```
  - PIS - ```br.eng.r2a.dokument.documents.brazil.PIS```
