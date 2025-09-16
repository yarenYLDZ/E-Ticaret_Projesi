### 🛒 Terminal Tabanlı E-Ticaret Uygulaması

Bu projede, Java kullanarak terminal tabanlı bir e-ticaret sistemi geliştirdim. Uygulama temel olarak kullanıcıların sisteme kayıt olabildiği, giriş yapabildiği, ürünleri arayıp sipariş verebildiği basit ama işlevsel bir yapı sunuyor. Tüm etkileşim terminal menüsü üzerinden gerçekleşiyor.

---

## 🧩 Projenin Amacı

Bu uygulamayı geliştirirken asıl amacım; kullanıcı yönetimi, şifreleme, ürün yönetimi ve sipariş süreçlerini kapsayan bir sistem mimarisi kurmak ve bunu Java, PostgreSQL ve Maven kullanarak uçtan uca hayata geçirmekti. Uygulamanın gerçek dünya kullanımına yakın özellikler taşımasına dikkat ettim.

---

## 🔐 Kullanıcı İşlemleri

- 👤 **Kayıt Olma**  
  Kullanıcılar sisteme e-posta ve şifre ile kayıt olabiliyor. Şifreler **SHA-256** algoritması ile şifrelenerek güvenli bir şekilde veritabanına kaydediliyor.

- 🔑 **Giriş Yapma**  
  Daha önce kayıt olmuş kullanıcılar, doğru e-posta ve şifre bilgileriyle sisteme giriş yapabiliyor. Yanlış girişlerde sistem uyarı veriyor.

- 🚫 **Giriş Yapmadan Sipariş Verilemez**  
  Sisteme giriş yapılmadan sipariş oluşturulmasına izin verilmiyor. Bu şekilde sadece doğrulanmış kullanıcılar işlem yapabiliyor.

---

## 🛍️ Ürün ve Sipariş Yönetimi

- 🔍 **Ürün Arama**  
  Kullanıcılar ürünleri isimlerine göre terminal üzerinden arayabiliyor. Arama, veritabanındaki ürünlerle eşleştirilerek sonuç döndürüyor.

- 🧾 **Sipariş Oluşturma**  
  Giriş yapmış kullanıcılar istedikleri ürünleri seçerek sipariş oluşturabiliyor.

- 📦 **Stok Takibi**  
  Her ürünün bir stok bilgisi var. Eğer bir ürün stokta yoksa, sipariş verilmesine izin verilmiyor. Böylece gerçekçi bir alışveriş senaryosu oluşturuluyor.

---

## 🧭 Menü Sistemi

Tüm kullanıcı etkileşimleri terminal üzerinden bir menü yapısıyla sunuluyor. Menü, kullanıcıların hangi işlemi yapmak istediklerini seçmeleri için açık ve sade bir şekilde yönlendirme sağlıyor. Örneğin:

```text
1 - Kayıt Ol
2 - Giriş Yap
3 - Ürün Ara
4 - Sipariş Oluştur
5 - Çıkış
