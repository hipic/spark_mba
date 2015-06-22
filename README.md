# spark_mba
Market Basket Analysis in Spark

It is to extract ngram from transaction data for market basket analysis, which is to support the paper:

(1)	Jongwook Woo, “Market Basket Analysis using Spark”, in Journal of Science and Technology, April 2015, Volume 5, No 4, pp207-209, ISSN 2225-7217, ARPN

You can download the paper at "http://www.ejournalofscience.org/archive/vol5no4/vol5no4_5.pdf"


First of all, you need to run spark-shell and copy/paste the code. How to run Spark on EC2 is shown here:  http://dal-cloudcomputing.blogspot.kr/2015/06/how-to-set-up-spark-on-ec2.html

Assuming you have the sample data as follows:
osboxes@osboxes:~/Downloads$ scp -i ~/.ssh/ampcamp3.pem data220K.txt  root@ec2-184-72-169-167.compute-1.amazonaws.com:~/spark/data/
data220K.txt                                                                              100%  208KB 208.3KB/s   00:00    
The sample input looks like this:
baguette soda hering cracker heineken olives corned_b
avocado cracker artichok heineken ham turkey sardines
olives bourbon coke turkey ice_crea ham peppers
hering corned_b apples olives steak avocado turkey

log in to EC2 as follows:
osboxes@osboxes:~/Downloads$ ssh -i ~/.ssh/ampcamp3.pem root@ec2-184-72-169-167.compute-1.amazonaws.com

At EC2, you need to upload a sample data to HDFS:
root@ip-10-69-128-228 ~]$ cd spark/data/
root@ip-10-69-128-228 data]$ ~/ephemeral-hdfs/bin/hadoop fs -put data220K.txt /user/root/data/
Warning: $HADOOP_HOME is deprecated.

Once you run the spark MBA code at spark-shell, you will see the following output:
root@ip-10-69-128-228 data]$ ~/ephemeral-hdfs/bin/hadoop fs -cat data/result220K/part-00000 | more
Warning: $HADOOP_HOME is deprecated.

(908,cracker+heineken)
(860,artichok+heineken)
(820,bourbon+olives)
(800,bourbon+cracker)
(796,corned_b+hering)
(604,chicken+heineken)
(552,heineken+sardines)
(504,coke+ice_crea)
(504,chicken+coke)
(484,ham+heineken)
(468,hering+soda)
(468,baguette+soda)
(464,cracker+hering)
(460,ham+turkey)
(448,olives+soda)
(448,corned_b+olives)
(444,ice_crea+turkey)
(436,ham+olives)
(432,avocado+cracker)
(428,artichok+avocado)
(424,coke+turkey)

