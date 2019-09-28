package com.example.aarrowapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.aarrowapp.database.models.AuditEntity
import com.example.aarrowapp.databinding.ListitemMainEmployeeAuditBinding

class AuditListAdapter(private val context: Context) : RecyclerView.Adapter<AuditViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var audits = emptyList<AuditEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuditViewHolder {
        val auditBinding = DataBindingUtil.inflate<ListitemMainEmployeeAuditBinding>(
            inflater,
            R.layout.listitem_main_employee_audit,
            parent,
            false
        )
        return AuditViewHolder(auditBinding)
    }

    override fun getItemCount(): Int {
        return audits.size
    }

    override fun onBindViewHolder(holder: AuditViewHolder, position: Int) {

        val audit = audits[position]
        holder.bind(audit)
        holder.itemView.setOnClickListener {
//            val intent = Intent(context, NewAuditActivity::class.java)
            val intent = Intent(context, AuditActivity::class.java)
            intent.putExtra(AUDIT_UID, audit.uid)
            context.startActivity(intent)
        }

    }

    fun setAudits(audits: List<AuditEntity>) {
        this.audits = audits
        notifyDataSetChanged()
    }

    companion object {
        const val AUDIT_UID = "audit_uid"
    }


}