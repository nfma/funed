(ns funed.core
  (:import [javax.mail.internet MimeMessage InternetAddress MimeMessage$RecipientType]
           [javax.mail Session Transport]))

(defn -main []
  (let [p (doto (System/getProperties)
            (.setProperty "mail.smtp.host", "banana")) 
        s (Session/getDefaultInstance p)
        m (doto (MimeMessage. s)
            (.setFrom (InternetAddress. "updates@warlordhunters.com"))
            (.addRecipient MimeMessage$RecipientType/TO, (InternetAddress. "updates@warlordhunters.com"))
            (.setSubject "We love you ned!")
            (.setText "Without us, you would be just a terrible web developer!"))]
    (doseq [t (range 10000)]
      (Thread/sleep 200)
      (Transport/send m))))
