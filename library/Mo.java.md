---
data:
  _extendedDependsOn: []
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':warning:'
  attributes: {}
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 421, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.8/x64/lib/python3.10/subprocess.py\"\
    , line 526, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "package library;\n\nimport java.util.*;\n\nclass Mo {\n\tpublic abstract\
    \ class Operators {\n\t\tOperators() {  }\n\n\t\tabstract void addFirst(int idx);\n\
    \t\tabstract void addLast(int idx);\n\t\tabstract void removeFirst(int idx);\n\
    \t\tabstract void removeLast(int idx);\n\t\tabstract void find(int idx);\n\t}\n\
    \n\tpublic final int n;\n\tpublic final Operators op;\n\n\t// O(1)\n\tMo(int n,\
    \ Operators op) {\n\t\tthis.n = n;\n\t\tthis.op = op;\n\t}\n\n\t// O(QlogQ+aNQ^(1/2))\n\
    \t// [l, r) query\n\tpublic final void query(final Pair.II[] query) {\n\t\tint\
    \ q = query.length;\n\t\tint blockSize = n / Math.min(Math.max((int)Math.ceil(Math.sqrt(q)),\
    \ 1), n);\n\t\t\n\t\tInteger ord[] = new Integer[q];\n\t\tfor(int i = 0; i < q;\
    \ i ++) ord[i] = i;\n\t\tComparator<Integer> cmp = (sort1, sort2) -> {\n\t\t\t\
    int aBlock = query[sort1].a / blockSize;\n\t\t\tint bBlock = query[sort2].a /\
    \ blockSize;\n\t\t\tif(aBlock != bBlock) return Integer.compare(aBlock, bBlock);\n\
    \t\t\treturn ((aBlock & 1) == 0 ? 1 : -1) * Integer.compare(query[sort1].b, query[sort2].b);\n\
    \t\t};\n\t\tArrays.sort(ord, cmp);\n\t\t\n\t\tint l = 0;\n\t\tint r = 0;\n\t\t\
    for(int idx : ord) {\n\t\t\twhile(l > query[idx].a) op.addFirst(-- l);\n\t\t\t\
    while(r < query[idx].b) op.addLast(r ++);\n\t\t\twhile(l < query[idx].a) op.removeFirst(l\
    \ ++);\n\t\t\twhile(r > query[idx].b) op.removeLast(-- r);\n\t\t\top.find(idx);\n\
    \t\t}\n\t}\n}"
  dependsOn: []
  isVerificationFile: false
  path: library/Mo.java
  requiredBy: []
  timestamp: '2022-11-02 13:10:22+09:00'
  verificationStatus: LIBRARY_NO_TESTS
  verifiedWith: []
documentation_of: library/Mo.java
layout: document
redirect_from:
- /library/library/Mo.java
- /library/library/Mo.java.html
title: library/Mo.java
---
