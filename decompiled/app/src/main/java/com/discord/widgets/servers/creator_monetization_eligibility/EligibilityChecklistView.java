package com.discord.widgets.servers.creator_monetization_eligibility;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.h2;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.view.text.LinkifiedTextView;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EligibilityChecklistView.kt */
/* loaded from: classes2.dex */
public final class EligibilityChecklistView extends LinearLayout {
    private List<Requirement> lastRequirements;

    /* compiled from: EligibilityChecklistView.kt */
    public static final /* data */ class Requirement {
        private final CharSequence description;
        private final boolean isMet;
        private final CharSequence title;

        public Requirement(CharSequence charSequence, CharSequence charSequence2, boolean z2) {
            m.checkNotNullParameter(charSequence, "title");
            m.checkNotNullParameter(charSequence2, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
            this.title = charSequence;
            this.description = charSequence2;
            this.isMet = z2;
        }

        public static /* synthetic */ Requirement copy$default(Requirement requirement, CharSequence charSequence, CharSequence charSequence2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = requirement.title;
            }
            if ((i & 2) != 0) {
                charSequence2 = requirement.description;
            }
            if ((i & 4) != 0) {
                z2 = requirement.isMet;
            }
            return requirement.copy(charSequence, charSequence2, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final CharSequence getTitle() {
            return this.title;
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getDescription() {
            return this.description;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsMet() {
            return this.isMet;
        }

        public final Requirement copy(CharSequence title, CharSequence description, boolean isMet) {
            m.checkNotNullParameter(title, "title");
            m.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
            return new Requirement(title, description, isMet);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Requirement)) {
                return false;
            }
            Requirement requirement = (Requirement) other;
            return m.areEqual(this.title, requirement.title) && m.areEqual(this.description, requirement.description) && this.isMet == requirement.isMet;
        }

        public final CharSequence getDescription() {
            return this.description;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            CharSequence charSequence = this.title;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            CharSequence charSequence2 = this.description;
            int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
            boolean z2 = this.isMet;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public final boolean isMet() {
            return this.isMet;
        }

        public String toString() {
            StringBuilder sbU = a.U("Requirement(title=");
            sbU.append(this.title);
            sbU.append(", description=");
            sbU.append(this.description);
            sbU.append(", isMet=");
            return a.O(sbU, this.isMet, ")");
        }
    }

    public EligibilityChecklistView(Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ EligibilityChecklistView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void bind(List<Requirement> requirements) {
        m.checkNotNullParameter(requirements, "requirements");
        if (m.areEqual(requirements, this.lastRequirements)) {
            return;
        }
        removeAllViews();
        Drawable colorDrawable = new ColorDrawable(ColorCompat.getThemedColor(this, R.attr.colorBackgroundAccent));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        boolean z2 = true;
        for (Requirement requirement : requirements) {
            if (z2) {
                z2 = false;
            } else {
                View view = new View(getContext());
                view.setBackground(colorDrawable);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, DimenUtils.dpToPixels(1));
                marginLayoutParams.leftMargin = DimenUtils.dpToPixels(16);
                marginLayoutParams.rightMargin = DimenUtils.dpToPixels(16);
                view.setLayoutParams(marginLayoutParams);
                addView(view);
            }
            View viewInflate = layoutInflaterFrom.inflate(R.layout.view_eligibility_checklist_row, (ViewGroup) null, false);
            int i = R.id.description;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) viewInflate.findViewById(R.id.description);
            if (linkifiedTextView != null) {
                i = R.id.eligibility_indicator;
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.eligibility_indicator);
                if (imageView != null) {
                    i = R.id.title;
                    TextView textView = (TextView) viewInflate.findViewById(R.id.title);
                    if (textView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                        m.checkNotNullExpressionValue(new h2(constraintLayout, linkifiedTextView, imageView, textView), "ViewEligibilityChecklist…g.inflate(layoutInflater)");
                        m.checkNotNullExpressionValue(imageView, "eligibilityIndicator");
                        imageView.setActivated(requirement.isMet());
                        m.checkNotNullExpressionValue(textView, "title");
                        textView.setText(requirement.getTitle());
                        m.checkNotNullExpressionValue(linkifiedTextView, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
                        linkifiedTextView.setText(requirement.getDescription());
                        addView(constraintLayout);
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        }
    }

    @Override // android.view.View
    public void onFinishInflate() throws Resources.NotFoundException {
        super.onFinishInflate();
        setOrientation(1);
        if (isInEditMode()) {
            CharSequence charSequenceJ = b.j(this, R.string.guild_role_subscription_settings_eligibility_requirement_members_eligible, new Object[]{50}, null, 4);
            String string = getResources().getString(R.string.guild_role_subscription_settings_eligibility_requirement_members_description);
            m.checkNotNullExpressionValue(string, "resources.getString(\n   …cription,\n              )");
            String string2 = getResources().getString(R.string.guild_role_subscription_settings_eligibility_requirement_violations_eligible);
            m.checkNotNullExpressionValue(string2, "resources.getString(\n   …_eligible\n              )");
            String string3 = getResources().getString(R.string.guild_role_subscription_settings_eligibility_requirement_violations_description);
            m.checkNotNullExpressionValue(string3, "resources.getString(\n   …cription,\n              )");
            bind(n.listOf((Object[]) new Requirement[]{new Requirement(charSequenceJ, string, true), new Requirement(string2, string3, true)}));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EligibilityChecklistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        this.lastRequirements = n.emptyList();
    }
}
