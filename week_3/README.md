# Mikroservice mimarisi ve monolith mimariyi karşılaştıran bir yazı yazın. (10 PUAN)

## MONOLİTİK MİMARİ
### Avantajlar
* KÜÇÜKk ekipler iÇin y�netilmesi ve geli�tirmesi kolayd�r.
* CI/CD ve Test süreçleri neredeyse DevOPS gerektirmez.
* Birden fazla ekip ihtiyacı duymaz aynı anda birden fazla modülle çalışılabilirsiniz (Bunun bir avantajdan ziyade dezavantaj olduğunu göreceğiz)
### Dezavantajlar
* Zamanla yeni feature ekleme ve optimizasyon zorlaşır.
* Bağımlılık ve Kod tekrarından dolayı versiyonlar arasında sorunlar yaşanır.
* Proje bir bütün olduğundan, projenin bir bölümü auto scale yapılamaz tüm projeyi scale etmeniz gerekir.
* Farklı framework/programlama dili kullanarak, daha stabil ve uygun maliyetle sunabileceğiniz modülleri proje içinde yazmanız gerekir (örneğin: AWS Lambda kullanmak)
* Tüm proje aynı veritabanını kullanacağından performans optimizasyonu gerekir.
* Sık kullanılan ve yüksek kaynak kullanımına sahip bir modülünüz için tüm sistem kaynaklarını arttırmanız gerekir.
* Projeye yeni dahil olacak geliştiriciler için anlaması güç ve zaman alacak bir code base sunar.

## Mikroservis Mimarisi 
### Avantajları
* Farklı featurelar için tüm code base üzerinde değişiklik yapmak zorunda değilsiniz.
* Bağımsız servislerle daha sade bir code base kazanacak, yeni personel istihdamında zaman kazanacaksınız.
* İstediğiniz bir servisi bağımsız olarak scale edebilecek, ekstra kaynak ihtiyacı duymayan servisleriniz için gereksiz maliyetten kurtulacaksınız.
* Bir Servisde yapılan hata diğer servislerin aksamasına sebep olmayacak.
* Servisleriniz için dilediğiniz framework/programlama dili kullanabilecek, dilediğiniz zaman geçiş yapabileceksiniz.
* Her servis için farklı veritabanları kullanabilecek, veri akışını hızlandırıp performansı ölçeklendirebileceksiniz.

### Dezavantajlar:

* Bu mimarinin büyük avantajları olsa da diğer mimariler gibi dezavantaları da bulunmaktadır. Bu yüzden 
oluşturacağınız projelerde tüm durumları göz önüne alarak doğru seçimi yapmak durumundayız. Mikroservisler monolotik uygulamalara göre geliştiriciler için farklı kompleks sorunlar getirir.
* Servisler arası iletişim ve uyumlu şekilde çalışması zorlayıcıdır. 100 lerce mikroservisiniz olabilir bunların 
  iletişimi güvenli ve sorunsuz olmalıdır. Mikro projelerde debug etmek zorlaşır bu sorunu çözmek için güçlü bir loglama alt yapısı ve monitoring araçları kullanılmalıdır.
* Unit test mikroservisler için basitken integration test daha zor hale gelir.
* Her mikrosersvis kendi API endpointlerine sahiptir. Değişiklik yapmak kolay olmasına rağmen bu endpointlere istek 
  atılan başka servisleri göz önüne almalıyız. Kısacası sahip olduğunuz mikroservisleri kimlerin kullandığını ve business logice hakim olmanız gerekir.
* Mikro servis mimarisinin verimli çalışması için, güvenlik ve bakım desteği ile yeterli barındırma altyapısına ve 
  tüm hizmetleri anlaya, yönetebilen nitelikli geliştirme ekiplerine ihtiyacınız vardır.