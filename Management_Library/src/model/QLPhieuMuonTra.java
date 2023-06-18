package model;

import java.util.List;

public class QLPhieuMuonTra implements ThuThu {
	List<PhieuMuon>listPhieuMuon;
	QLSach qlSach;
	

	public QLPhieuMuonTra(List<PhieuMuon> listPhieuMuon, QLSach qlSach) {
		super();
//		listPhieuMuon=new ArrayList<>();
		this.listPhieuMuon = listPhieuMuon;
		this.qlSach = qlSach;
	}

	public List<PhieuMuon> getListPhieuMuon() {
		return listPhieuMuon;
	}

	public void setListPhieuMuon(List<PhieuMuon> listPhieuMuon) {
		this.listPhieuMuon = listPhieuMuon;
	}

	@Override
	public List<Object> timKiemTheoID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> timKiemTheoTen(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void them(Object object) {
		
		PhieuMuon obj = (PhieuMuon) object;
		listPhieuMuon.add(obj);
		for(Sach s: qlSach.listSach) {
			
			if(obj.sach.getiD().equals(s.getiD())) {
				s.setSoLuongChoMuon(s.getSoLuongChoMuon()+1);
			}
		}
	}

	@Override
	public void xoa(String id) {
		PhieuMuon phieuMuon = tim(id);
		if(phieuMuon != null) {
			listPhieuMuon.remove(phieuMuon);
		}
	}

	@Override
	public void capNhat(String phieuMuonID, Sach sachMoi, Date ngayMuonMoi, Date ngayDuKienTraMoi) {
		PhieuMuon phieuMuon = tim(phieuMuonID);
        	if (phieuMuon != null) {
            		if (phieuMuon.getTrangThai().equals("Da Tra")) {
                		phieuMuon.setSach(null);
            		}
           		phieuMuon.setSach(sachMoi);
            		phieuMuon.setNgayMuon(ngayMuonMoi);
            		phieuMuon.setNgayDuKienTra(ngayDuKienTraMoi);
        	} 
		else {
            	System.out.println("Khong tim thay phieu muon co ID: " + phieuMuonID);
        	}	
	}
	
	@Override
	public int getSoLuong() {
		// TODO Auto-generated method stub
		return 0;
	}
}
