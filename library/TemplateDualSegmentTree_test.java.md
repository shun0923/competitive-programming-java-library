---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':heavy_check_mark:'
    path: library/TemplateDualSegmentTree.java
    title: library/TemplateDualSegmentTree.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: false
  _pathExtension: java
  _verificationStatusIcon: ':heavy_check_mark:'
  attributes:
    PROBLEM: https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_2_E
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DSL_2_E\n\
    \npackage library;\n\nimport library.Solver;\nimport library.TemplateDualSegmentTree;\n\
    \npublic class TemplateDualSegmentTree_test extends Solver {\n\tpublic static\
    \ void main(final String[] args) { main(args, new TemplateDualSegmentTree_test());\
    \ }\n\n\tpublic void solve() {\n\t\tint n = ni();\n\t\tint q = ni();\n\t\tTemplateDualSegmentTree<long[]>\
    \ st = new TemplateDualSegmentTree<>(n,\n\t\t\t\t() -> new long[]{0}, (ele1, ele2)\
    \ -> ele1[0] += ele2[0]);\n\t\tfor(int i = 0; i < q; i ++) {\n\t\t\tif(ni() ==\
    \ 0) st.update(ni() - 1, ni(), new long[]{nl()});\n\t\t\telse prtln(st.get(ni()\
    \ - 1)[0]);\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/TemplateDualSegmentTree.java
  isVerificationFile: true
  path: library/TemplateDualSegmentTree_test.java
  requiredBy: []
  timestamp: '2022-10-04 10:50:43+09:00'
  verificationStatus: TEST_ACCEPTED
  verifiedWith: []
documentation_of: library/TemplateDualSegmentTree_test.java
layout: document
redirect_from:
- /verify/library/TemplateDualSegmentTree_test.java
- /verify/library/TemplateDualSegmentTree_test.java.html
title: library/TemplateDualSegmentTree_test.java
---
