package com.discord.utilities.search.query.parsing;

import android.content.Context;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.filter.FilterNode;
import d0.z.d.Intrinsics3;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: QueryParser.kt */
/* renamed from: com.discord.utilities.search.query.parsing.QueryParser$Companion$getFromFilterRule$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class QueryParser3 extends Rule<Context, QueryNode, Object> {
    public final /* synthetic */ Pattern $fromFilterPattern;
    public final /* synthetic */ CharSequence $localizedFrom;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryParser3(CharSequence charSequence, Pattern pattern, Pattern pattern2) {
        super(pattern2);
        this.$localizedFrom = charSequence;
        this.$fromFilterPattern = pattern;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        FilterNode filterNode = new FilterNode(FilterType.FROM, this.$localizedFrom);
        Intrinsics3.checkNotNullParameter(filterNode, "node");
        return new ParseSpec<>(filterNode, state);
    }
}
