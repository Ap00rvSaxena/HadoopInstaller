# HadoopInstaller

Hadoop Installer is an utility tool for installing Hadoop in a Linux based OS.It provide user with option to install hadoop with single node cluster or Multi-Node cluster, provides a user to install hadoop with a single click with automated configuration, user can edit the configuration file to its requirement whenever he needs to.

##Installation Guide
<li>1.LogIn in the Application with UserName and Password (General Authentication)</li>

* Username and Password for the application is "redhat".

<li>2.Click Next.</li>

* Information related to Hadoop

<li>3.Select a Hadoop tar file to install.</li>

<li>4.Select the Mode of Installation.</li>

* Basic-Creates a new User with username and password as "hadoop" install hadoop as single node cluster.
* Advance-Creates a new User as specifed by User and installes hadoop in a multinode cluster enviornment.

<li>5.Click Install after selecting mode.</li>
* Installtion takes a lttle time
* Creates a New user
* Enables ssh services and make a rsa key
* Extract the tar file and store it in the Home directory if the user
* Updates User Enviornment variable and Bash

<li>6.Click on Edit Configuration to edit files automatically or else Edit Manually</li>
* Edits core-site.xml
* Edits hdfs-site.xml
* Edits mapred-site.xml
* Edits tyarn-site.xml

<li>7.Click Next and to start services automatically</li>

<li>8.Click on the Links to see it on browser</li>

### Prerequisites
<li>System should have a stable version of a Java Eviorment to support Hadoop</li>
<li>If choose Basic Mode there should not be a User with username as "hadoop"</li>
<li>If having problem with localhost not found make an entry for localhost in /etc/hosts

## Buid with
* Eclipse
* Uses Shell Scripts
* Java 

#### Note
Installer Advance mode is still in development stage will be updated in the next release.
