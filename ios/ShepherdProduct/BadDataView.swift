//
//  BadDataView.swift
//  ShepherdProduct
//
//  Created by k4keye on 2022/03/09.
//

import SwiftUI

struct BadDataView: View {
    
    var body: some View {
        VStack{
            Text("과대 광고 이력이 있습니다")
                .font(.system(size: 20))
                .fontWeight(.bold)
                .foregroundColor(Color.orange)
            
            Image("icon_bad")
                .resizable()
                .frame(width: 100, height: 100)
            List{
                ForEach(1...4, id: \.self){ index in
                    BadListItem(name: "\(index)", title: "\(index)")
                }
            }
        }
       

    }
}


struct BadListItem: View{
    let name : String
    let title : String
    
    var body: some View{
        
        VStack{
            HStack{
                Text("회사명 : ")
                    .fontWeight(.bold)
                    .foregroundColor(Color.orange)
                Text("\(name)")
                    .foregroundColor(Color.orange)
            }
            HStack{
                Text("제품명 : ")
                Text("\(name)")
            }
        }
    }
    
}

struct BadDataView_Previews: PreviewProvider {
    static var previews: some View {
        BadDataView()
    }
}
