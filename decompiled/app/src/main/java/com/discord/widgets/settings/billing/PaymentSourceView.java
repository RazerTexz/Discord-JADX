package com.discord.widgets.settings.billing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StyleRes;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.PaymentSourceViewBinding;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.utilities.billing.PremiumUtils2;
import com.discord.utilities.time.TimeUtils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: PaymentSourceView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PaymentSourceView extends ConstraintLayout {
    private final PaymentSourceViewBinding binding;

    public PaymentSourceView(Context context) {
        this(context, null, 0, 6, null);
    }

    public PaymentSourceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ PaymentSourceView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void bindCard(ModelPaymentSource.ModelPaymentSourceCard paymentSource) {
        TextView textView = this.binding.f15212f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.paymentSourceViewTitle");
        FormatUtils.m222n(textView, C5419R.string.payment_source_card_ending, new Object[]{paymentSource.getBrand(), paymentSource.getLast4()}, null, 4);
        TimeUtils timeUtils = TimeUtils.INSTANCE;
        int expiresMonth = paymentSource.getExpiresMonth();
        TextView textView2 = this.binding.f15211e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.paymentSourceViewSubtext");
        Context context = textView2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.paymentSourceViewSubtext.context");
        String localizedMonthName = timeUtils.getLocalizedMonthName(expiresMonth, context);
        TextView textView3 = this.binding.f15211e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.paymentSourceViewSubtext");
        FormatUtils.m222n(textView3, C5419R.string.payment_source_card_expires, new Object[]{localizedMonthName, Integer.valueOf(paymentSource.getExpiresYear())}, null, 4);
    }

    private final void bindPaypal(ModelPaymentSource.ModelPaymentSourcePaypal paymentSource) {
        this.binding.f15212f.setText(C5419R.string.payment_source_paypal);
        TextView textView = this.binding.f15211e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.paymentSourceViewSubtext");
        textView.setText(paymentSource.getEmail());
    }

    public final void bind(ModelPaymentSource paymentSource, boolean isPremium) {
        Intrinsics3.checkNotNullParameter(paymentSource, "paymentSource");
        this.binding.f15208b.setImageResource(PremiumUtils2.getPaymentSourceIcon(paymentSource));
        TextView textView = this.binding.f15209c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.paymentSourceViewInvalid");
        textView.setVisibility(paymentSource.getInvalid() ? 0 : 8);
        ImageView imageView = this.binding.f15210d;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.paymentSourceViewPremium");
        imageView.setVisibility(isPremium ? 0 : 8);
        if (paymentSource instanceof ModelPaymentSource.ModelPaymentSourcePaypal) {
            bindPaypal((ModelPaymentSource.ModelPaymentSourcePaypal) paymentSource);
        } else if (paymentSource instanceof ModelPaymentSource.ModelPaymentSourceCard) {
            bindCard((ModelPaymentSource.ModelPaymentSourceCard) paymentSource);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentSourceView(Context context, AttributeSet attributeSet, @StyleRes int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.payment_source_view, this);
        int i2 = C5419R.id.payment_source_view_icon;
        ImageView imageView = (ImageView) findViewById(C5419R.id.payment_source_view_icon);
        if (imageView != null) {
            i2 = C5419R.id.payment_source_view_icon_wrapper;
            CardView cardView = (CardView) findViewById(C5419R.id.payment_source_view_icon_wrapper);
            if (cardView != null) {
                i2 = C5419R.id.payment_source_view_invalid;
                TextView textView = (TextView) findViewById(C5419R.id.payment_source_view_invalid);
                if (textView != null) {
                    i2 = C5419R.id.payment_source_view_premium;
                    ImageView imageView2 = (ImageView) findViewById(C5419R.id.payment_source_view_premium);
                    if (imageView2 != null) {
                        i2 = C5419R.id.payment_source_view_subtext;
                        TextView textView2 = (TextView) findViewById(C5419R.id.payment_source_view_subtext);
                        if (textView2 != null) {
                            i2 = C5419R.id.payment_source_view_title;
                            TextView textView3 = (TextView) findViewById(C5419R.id.payment_source_view_title);
                            if (textView3 != null) {
                                PaymentSourceViewBinding paymentSourceViewBinding = new PaymentSourceViewBinding(this, imageView, cardView, textView, imageView2, textView2, textView3);
                                Intrinsics3.checkNotNullExpressionValue(paymentSourceViewBinding, "PaymentSourceViewBinding…ater.from(context), this)");
                                this.binding = paymentSourceViewBinding;
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
