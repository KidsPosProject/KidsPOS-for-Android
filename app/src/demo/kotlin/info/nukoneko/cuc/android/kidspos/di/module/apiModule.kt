package info.nukoneko.cuc.android.kidspos.di.module

import info.nukoneko.cuc.android.kidspos.api.APIService
import info.nukoneko.cuc.android.kidspos.entity.Item
import info.nukoneko.cuc.android.kidspos.entity.Sale
import info.nukoneko.cuc.android.kidspos.entity.Staff
import info.nukoneko.cuc.android.kidspos.entity.Store
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import org.koin.dsl.module.module
import java.util.*

val apiModule = module {
    single<APIService> {
        object : APIService {
            override fun fetchStores(): Observable<List<Store>> {
                return Observable.just(listOf(Store(1, "お店1"), Store(2, "お店2")))
            }

            override fun createSale(receiveMoney: Int, saleItemCount: Int, sumPrice: Int, saleItemsList: String, storeId: Int, staffCode: String): Deferred<Sale> {
                val sale = Sale(1, "123456", Date(),
                        saleItemCount, sumPrice, saleItemsList, storeId, staffCode.toIntOrNull() ?: 0)
                return CompletableDeferred(sale)
            }

            override fun getItem(itemBarcode: String): Single<Item> {
                return Single.just(Item(1, itemBarcode, "DemoItem", 100, 1, 1))
            }

            override fun getStaff(staffBarcode: String): Single<Staff> {
                return Single.just(Staff(staffBarcode, "DemoStaff"))
            }
        }
    }
}