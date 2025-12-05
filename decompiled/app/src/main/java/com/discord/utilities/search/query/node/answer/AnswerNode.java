package com.discord.utilities.search.query.node.answer;

import android.content.Context;
import android.text.SpannableStringBuilder;
import com.discord.utilities.search.network.SearchQuery;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.validation.SearchData;
import java.util.Set;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AnswerNode.kt */
/* loaded from: classes2.dex */
public abstract class AnswerNode extends QueryNode {
    public abstract Set<FilterType> getValidFilters();

    public abstract boolean isValid(SearchData searchData);

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Context context) {
        render2(spannableStringBuilder, context);
    }

    public abstract void updateQuery(SearchQuery.Builder queryBuilder, SearchData searchData, FilterType filterType);

    /* renamed from: render, reason: avoid collision after fix types in other method */
    public void render2(SpannableStringBuilder builder, Context renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        builder.append(getText()).append(' ');
    }
}
