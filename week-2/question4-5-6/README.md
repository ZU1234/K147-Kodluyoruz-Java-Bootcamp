## 4- Java dünyasındaki framework’ler ve çözdükleri problemler nedir? Kod Örneklendirini de içermelidir. (10 Puan)

Framework daha önceden yazılmış, konfigüre edilmiş, taslak olarak kullanılabilen projelerdir. Herşeyi yeniden yazmak ve konfigüre etmek yerine kullanıcıların sadece kendilerine özel kodu yazarak uygulamayı tamamlamasını sağlarlar. Frameworkler database access, routing, authorization, authentication, templating gibi görevleri yapacak uygulamaları içerirler.

### Spring

* Inversion of Control (Kontrolü Spring'e Çevirme) yaklaşımı ile yazılım geliştiricilere büyük kolaylıklar sağlar.
* Dependency Injection (Bağımlılık Enjeksiyonu)Şirketlerin tüm yönetici yönetimini kendi üstlenerek, yazılım mühendisliğinde arzulanan amaç arası bağlantıyı koparma (de-coupling) işleyişini esnek bir şekilde karşılamaktadır.

### Maven

* jar dosyalarının yönetiminde oldukça avantaj sağlar.
* hazır Project Template’ler sunar. Bu şablonlar üzerinde projelerimizi geliştirirsek Maven’a hakim olan biri geliştirmiş olduğumuz projelere çok kısa bir sürede adapte olabilir.
* versiyon takip sistemine sahip olması büyük avantajdır.

### Hibernate

* Hibernate, Java'daki ORM aracıdır.
* veri erişim katmanını geliştirmek için kullanılır.
* mantıksal iş modelini (POJO sınıfı) ilişkisel veritabanıyla (fiziksel model) eşleştirmek için kullanır.
* Veritabanı yapısındaki değişikliklere kolayca uyum sağlar.
* (POJO) sınıfına dayalı zengin sorgulama dili sağlar. Geliştiriciler etki alanı modelini kullanarak sorguyu yazar ve ORM aracı SQL sorgularını otomatik olarak oluşturur.
* ORM aracı, nesneler arasındaki ilişkiyi destekler.
* eşzamanlılığı da destekler.
* işlem yönetimini ve hata işlemeyi destekler.

### Quarkus

* JVM’den daha iyi performans gösteren
* OpenJDK projesinden “HotSpot”, Java kodunun yürütme katmanı olarak bir Java Sanal Makinesi (JVM) olarak kullanılır.
* Geliştiricilerin kod değişikliklerinin etkisini anında kontrol edebilmesi ve bunları hızla giderebilmesi için hot 
  reload yaparak anında derleme yapabilir.
* yerleşik Java kitaplıklarının ve standartlarının kullanılmasıdır.


## 5- Spring frameworkünün kullandığı design patternlar neler? (5 Puan)
Design pattern'lar yinelenen sorunları çözer ve geliştiricilerin ortak pattern'leri tanıyarak bir framework'un 
tasarımını anlamalarına yardımcı olur.

* Singleton pattern
* Factory Method pattern
* Proxy pattern
* Template pattern

olmak üzere Spring'in kullandığı 4 adet design pattern vardır.

## 6- SOA - Web Service - Restful Service - HTTP methods kavramlarını örneklerle açıklayınız.

### SOA
SOA anlaşılması ve uygulanması en zor olan mimari modellerden biridir.SOA farklı platformlar için belirli hizmetlerin sunulması esasına dayanmaktadır.SOA’nın dağıtık yazılım sistemlerinin kalitesini arttırma noktasında pek çok mimari kritere sahip olduğunu söylememiz gerekir. Yeniden kullanılabilirlik(reusability), uyumluluk(adaptability) ve bakım yeteneği(maintainability) bunlardan birkaçıdır. Ancak en önemlisi SOA’nın özellikle point-to-point entegrasyon yapan sistemlerdeki bağımlılıkları ortadan kaldıracak çözümleri içermesidir.

SOA temel bileşenleri
* Service
* Policies(ilkeler)
* EndPoints
* Contracts(sözleşmeler)
* Messages(mesajlar)
* Service Consumer(tüketici)

olmak üzere 6 bileşeni vardır.

### Wep Sevice
Web Servisler uygulama bileşenidir, açık protokolleri(open protocols) kullanarak haberleşir, kendi kendine yetebilen ve kendinden tanımlıdırlar, UDDI kullanılarak keşfedilebilir, diğer uygulamalar tarafından kullanılabilir, XML temeline dayanır yani XML tabanlı bir teknolojidir.

#### Web Service Çeşitleri
* SOAP : SOAP servisler  TCP protokolü üzerinden işlemler yürütüler. Mesaj method hazırlama, cevap ve hata mesajından oluşur.
* REST Servisler :  REST servisler URI ile ilgili metota HTTP üzerinden istekte bulunur. GET, POST, PUT, DELETE gibi HTTP metotları ile işlemler gerçekleştirilebilmektedir. SOAP gibi bir WDSL gerektirmez. REST servisler SOAP’a göre daha esnek ve hızlıdır.

### Restful Service

 REST mimari kullanımı gerçekleştiren web servisleridir denilebilir.rest servisler birer url üzerinden çalışırlar ve bu urller benzersizdir.Genellikle HTTP protokolü üzerinden çalışma gösteren RESTful servisleri, bilgisayar veya cihazlarda kullanılan internet tarayıcıları üzerinde yani Safari, Google Chrome, Mozilla, Opera gibi tarayıcılarda kullanılan sayfaların transferini sağlayabilmek açısından DELETE, PUT, POST gibi HTTP metotları sayesinde haberleşme sağlarlar.


* GET: Genellikle veri ya da veri listelerini getirmek için kullanılır.
* POST: Veri tabanına yeni bir kayıt eklemek için kullanılır.
* PUT: Veri tabanındaki verileri güncellemek için kullanılır.
* DELETE: Veri tabanındaki verileri silmek için kullanılır.

### HTTP

Bilgisayar ve ağ sistemleri arasında gerçekleşen iletişimde kullanılan uygulama katmanı protokolüdür. HTTP temelde 
www için istemci server veri iletişiminin temelini oluşturarak wep sayfalarında yer alan hypertext links kullanarak 
wep sayfalarını yüklemek için kullanılır. Tipik bir HTTP akışı, bir sunucuya istekte bulunan istemci(genellikle wep 
tarayıcı) ve ardından server içeirir.

* HTTP : Hypertext Transfer Protocol(Güvenli köprü metin aktarım protokolü)
* www  : World Wide Web
* server : sunucu
* request : istemci
* response : yanıt

istemci tarafından bir kaynağı almak için gönderilern mesajlar request ve sunucu tarafından gönderilen isteğe 
döndürülen cevaplar response olarak adlandırılır. 

* GET: Bu metod sunucudan veri almak için kullanılır. GET ve POST metodları en sık kullanılan metodlar olup sunucudaki kaynaklara erişmek için kullanılırlar.
* POST: Bu metod ile sunucuya veri yazdırabilirsiniz. Bu metodla özel veriler hem URL içinde hem de mesaj gövdesinde gönderilebilir.
* PUT: Bu metot ile servis sağlayıcılar üzerindeki bir kaynağı güncelleyebilirsiniz. Hangi kaynağı güncelleyecekseniz o kaynağın id'sini sona erdirecek.
* HEAD: GET yöntemiyle benzer işleve sahiptir ancak geri dönen yanıtta mesaj gövdesinde bulunmaz (yani ana başlıklar ve içerikleri GET yöntemiyle bölümleri). Bu nedenle GET mesajı gönderilmesinden önce bir kaynağın var olup olmadığını kontrol etmek için kullanılabilir.
* DELETE: Bu metod ile sunucudaki herhangi bir veriyi silebilirsiniz.
* CONNECT: Bir proxy sunucu üzerinden başka bir sunucuya bağlanmak ve proxy sunucuyu bir tünel gibi kullanmak için kullanılır.
* OPTIONS: Bu metod belli bir kaynak için kullanılabilecek HTTP metodlarını sunucudan sorgulamak için kullanılır.
* TRACE: Teşhis amaçlı kullanılan bir metoddur. Sunucu bu metodla gelen istek mesajının içeriğini aynen yanıt gövdesinde geri göndermelidir. Bu yöntemle sunucu ile istemci arasında bir vekil sunucu varsa bu sunucunun ve yaptığı değişikliklerin tespiti mümkün olabilir.
* PATCH: Bu metod bir kaynağa istediğiniz küçük çaplı değişimi yapmanızı sağlar.
* SEARCH: Bir dizinin altındaki kaynakları sorgulamak için kullanılır.

```
GET /index.html HTTP/1.1
Host: 127.0.0.1
```
Örnek bir get methodu kullanımı.
