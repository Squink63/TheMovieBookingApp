package com.abbc.mymoviebookingapp.ui.activities.movie

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.abbc.mymoviebookingapp.data.vos.movie.checkout.CheckoutSnackList
import com.abbc.mymoviebookingapp.data.vos.movie.snack.SnackVO
import com.abbc.mymoviebookingapp.databinding.ActivityMovieCheckOutBinding
import com.abbc.mymoviebookingapp.ui.adapters.movie.SnackCheckoutAdapter
import com.abbc.mymoviebookingapp.ui.fragments.dialog.TicketCancellationPolicyFragment
import com.abbc.mymoviebookingapp.ui.utils.TicketData

class MovieCheckOutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieCheckOutBinding
    private lateinit var mSnackCheckoutAdapter: SnackCheckoutAdapter

    private var mMovieName: String? = null
    private var mCinemaName: String? = null
    private var mCinemaDate: String? = null
    private var mCinemaTime: String? = null
    private var mCinemaLocation: String? = null
    private var mNumberOfTicket: Int? = null
    private var mTicketTotalPrice: Long? = 0L
    private var mSnackTotalPrice: Long = 0L
    private var mCheckout: String? = null
    private var mTicketList: MutableList<String> = mutableListOf()
    private lateinit var mSnackList: List<SnackVO>

    private var mTicketInfo: TicketData? = null
    private var mSnackInfo: CheckoutSnackList? = null

    companion object{
        private const val EXTRA_TICKET_INFO = "EXTRA_TICKET_INFO"
        private const val EXTRA_SNACK_INFO = "EXTRA_SNACK_INFO"
        fun newIntent(context: Context, ticketInfo: TicketData?, snackInfo: CheckoutSnackList?): Intent{
            val intent = Intent(context,MovieCheckOutActivity::class.java)
            intent.putExtra(EXTRA_TICKET_INFO, ticketInfo)
            intent.putExtra(EXTRA_SNACK_INFO, snackInfo)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieCheckOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mTicketInfo = intent?.getSerializableExtra(EXTRA_TICKET_INFO) as TicketData?
        mMovieName = mTicketInfo?.movieInfo?.movieName
        mCinemaName = mTicketInfo?.cinemaInfo?.cinemaName
        mCinemaDate = mTicketInfo?.cinemaInfo?.cinemaData
        mCinemaTime = mTicketInfo?.cinemaInfo?.cinemaTime
        mCinemaLocation = mTicketInfo?.cinemaInfo?.cinemaLocation
        mNumberOfTicket = mTicketInfo?.seatInfo?.numberOfTicket
        mTicketTotalPrice = mTicketInfo?.seatInfo?.ticketTotalPrice
        mSnackTotalPrice = mTicketInfo?.snackPrice ?: 0
        mTicketList = mTicketInfo?.seatInfo?.ticketList ?: mutableListOf()
        mSnackList = mTicketInfo?.snackList ?: listOf()

        Log.d("MovieCheck","$mMovieName,$mCinemaName,$mCinemaDate,$mCinemaTime,$mNumberOfTicket," +
                "$mTicketTotalPrice,$mSnackTotalPrice,$mTicketList,$mSnackList")

        mSnackInfo = intent?.getSerializableExtra(EXTRA_SNACK_INFO) as CheckoutSnackList?

        setUpListeners()
        setUpOrderFoodListRecyclerView()
    }

    private fun setUpListeners() {

        bindTicketData()

        binding.btnContinue.setOnClickListener {
            startActivity(MoviePaymentActivity.newIntent(this, mTicketInfo, mSnackInfo))
            finish()
        }


        binding.btnPolicy.setOnClickListener {
            val dialog = TicketCancellationPolicyFragment()
            dialog.show(supportFragmentManager,"Ticket Policy")
        }
    }

    private fun bindTicketData() {
        binding.tvMovieTitle.text = mMovieName
        binding.tvCinema.text = mCinemaName
        binding.tvCinemaDate.text = mCinemaDate
        binding.tvCinemaTime.text = mCinemaTime
        binding.tvCinemaLocation.text = mCinemaLocation
        binding.tvTicketCount.text = mNumberOfTicket.toString()
        binding.tvReceiptFoodAmount.text = "$mSnackTotalPrice Ks"

        val ticketTotalPrice = "${mTicketTotalPrice} Ks"
        binding.tvReceiptAmount.text = ticketTotalPrice

        val ticketName = getTicketList()
        binding.tvReceiptSeat.text = ticketName

        val total = "${((mTicketTotalPrice?.plus(mSnackTotalPrice) ?: 0) + 500)} Ks"
        binding.tvTotal.text = total

        Log.d("checkout","${setUpSnackList()}")
    }

    private fun setUpSnackList() : MutableList<SnackVO> {
        val snackList = mutableListOf<SnackVO>()
        for(snack in mSnackList) {
            if(snack.quantity > 0) {
                snackList.add(snack)
            }
        }
        return snackList
    }

    private fun getTicketList(): String {
        var ticket = ""
        if (mTicketList.isNotEmpty()){
            mTicketList.forEach {
                ticket += "$it,"
            }
            ticket = StringBuilder(ticket).also {
                it.deleteCharAt(it.lastIndex)
            }.toString()
        }
        return ticket
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setUpOrderFoodListRecyclerView() {
        mSnackCheckoutAdapter = SnackCheckoutAdapter()
        binding.rvFoodOrderList.adapter = mSnackCheckoutAdapter
        binding.rvFoodOrderList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        mSnackCheckoutAdapter.setNewData(setUpSnackList())
        mSnackCheckoutAdapter.notifyDataSetChanged()
    }

}